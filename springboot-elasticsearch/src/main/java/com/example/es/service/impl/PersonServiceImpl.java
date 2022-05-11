package com.example.es.service.impl;

import com.example.es.entity.Person;
import com.example.es.repository.PersonEsRepository;
import com.example.es.service.PersonService;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonEsRepository personEsRepository;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public String createUser(Person person) {
        Person person1 =  personEsRepository.save(person);
        if (person1 != null) {
            return person1.getId();
        }
        return null;
    }

    @Override
    public Person findPersonById(String id) {
        Optional<Person> person  =  personEsRepository.findById(id);
        return person.get();
    }

    @Override
    public void deleteIndex() {
        elasticsearchTemplate.deleteIndex(Person.class);
    }

    @Override
    public List<Person> searchHigh(String query) {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //高亮显示规则
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        //指定高亮字段
        highlightBuilder.field("name");
        //highlightBuilder.field("director");
        //添加查询的字段内容
        //String [] fileds = {"name", "director"};
        String[] fileds = {"name"};
        SearchRequestBuilder searchRequestBuilder = elasticsearchTemplate.getClient()
                .prepareSearch("person").setTypes("_doc");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.multiMatchQuery(query,"name"));
        searchRequestBuilder.setQuery(boolQueryBuilder);
        SearchResponse searchResponse = searchRequestBuilder.highlighter(highlightBuilder).execute().actionGet();

        //QueryBuilder matchQuery = QueryBuilders.multiMatchQuery(query, fileds);
        //搜索数据
//        SearchResponse response = elasticsearchTemplate.getClient().prepareSearch("person").setTypes("_doc")
//                .setQuery(matchQuery)
//                .highlighter(highlightBuilder)
//                .execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        System.out.println("记录数-->" + searchHits.getTotalHits());
        List<Person> list = new ArrayList<>();

        for(SearchHit hit : searchHits) {
            Person entity = new Person();
            //高亮字段
            if(!StringUtils.isEmpty(hit.getHighlightFields().get("name").toString())) {
                Text[] text = hit.getHighlightFields().get("name").getFragments();
                entity.setName(text[0].toString());
            }
            list.add(entity);
        }
        return list;
    }

    @Override
    public List<String> getParticipesResult(String text) {
        List<String> participesResultList = new ArrayList<>();
        AnalyzeRequest analyzeRequest = new AnalyzeRequest("person").text(text).analyzer("ik_smart");
        List<AnalyzeResponse.AnalyzeToken> tokenList = elasticsearchTemplate.getClient()
                .admin()
                .indices()
                .analyze(analyzeRequest)
                .actionGet()
                .getTokens();
        for (AnalyzeResponse.AnalyzeToken token : tokenList){
            participesResultList.add(token.getTerm());
        }
        return participesResultList;
    }
}
