package com.example.neo4j.service;

import com.example.neo4j.dto.GraphDTO;
import com.example.neo4j.entity.King;
import com.example.neo4j.entity.Queen;
import com.example.neo4j.entity.relation.FatherAndSonRelation;
import com.example.neo4j.repository.KingRepository;
import com.example.neo4j.repository.QueenRepository;
import org.neo4j.driver.internal.InternalNode;
import org.neo4j.driver.internal.InternalPath;
import org.neo4j.driver.internal.InternalRelationship;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.neo4j.ogm.session.Neo4jSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qiuyu
 * @date 2023年02月14日 15:23
 */
@Service
public class KingService {

    @Autowired
    private KingRepository kingRepository;

    @Autowired
    private QueenRepository queenRepository;

    /**
     * 保存皇帝信息
     *
     * @param list
     */
    public void saveKing(List<King> list) {
        list.forEach(king -> {
            kingRepository.save(king);
        });
    }

    /**
     * 保存皇后信息
     *
     * @param list
     */
    public void saveQueen(List<Queen> list) {
        list.forEach(queen -> {
            queenRepository.save(queen);
        });
    }

    public GraphDTO getKingAndQueen(String kingName) {
        //通过皇帝名字查询到当前皇帝皇后以及上一任皇帝皇后
        Iterator<Map<String, Object>> iterator = kingRepository.getBeforeAndNow(kingName);
        GraphDTO gto = mapToGraph(iterator);
        return gto;
    }



    private GraphDTO mapToGraph(
            Iterator<Map<String, Object>> neo4jDataIterator) {
        Map<Long, Object> nodeMap = new HashMap<>();
        Map<Long, Object> linkMap = new HashMap<>();

        while (neo4jDataIterator.hasNext()) {
            Map<String, Object> each = neo4jDataIterator.next();
            if (!each.containsKey("p")) {
                continue;
            }

            InternalPath internalPath = (InternalPath) each.get("p");
            //归纳出所有节点。
            for (Node node : internalPath.nodes()) {
                InternalNode internalNode = (InternalNode) node;
                if (nodeMap.containsKey(internalNode.id())) {
                    continue;
                }
                nodeMap.put(internalNode.id(), internalNode);
            }
            //归纳出所有关系。
            for (Relationship relation : internalPath.relationships()) {
                InternalRelationship internalRelation = (InternalRelationship) relation;
                if (linkMap.containsKey(internalRelation.id())) {
                    continue;
                }
                linkMap.put(internalRelation.id(), internalRelation);
            }
        }

        GraphDTO dto = new GraphDTO();
        dto.setNodes(nodeMap.values().stream().collect(Collectors.toList()));
        dto.setLinks(linkMap.values().stream().collect(Collectors.toList()));
        return dto;
    }






    /**
     * 查询一个皇帝信息，此处使用spring-data-neo4j 接口
     *
     * @param name
     */
    public King findByName(String name) {
        King t = kingRepository.findByName(name);
        return t;
    }


    /**
     * 获取当前节点下的所有king
     *
     * @param name
     * @return
     */
    public List<King> getKings(String name) {
        return kingRepository.getKings(name);
    }


    /**
     * 保存父子关系
     *
     * @param fatherName
     * @param sonName
     * @return
     */
    public void saveRelation(String fatherName, String sonName) {
        King from = kingRepository.findByName(fatherName);
        King to = kingRepository.findByName(sonName);
        FatherAndSonRelation fatherAndSonRelation = new FatherAndSonRelation();
        fatherAndSonRelation.setFrom(from);
        fatherAndSonRelation.setTo(to);
        from.addRelation(fatherAndSonRelation);
        kingRepository.save(from);
    }

    public void deleteAll(){
        kingRepository.deleteAll();
    }
}
