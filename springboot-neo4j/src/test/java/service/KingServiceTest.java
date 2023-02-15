package service;

import com.example.neo4j.Neo4jApplication;
import com.example.neo4j.entity.King;
import com.example.neo4j.entity.Queen;
import com.example.neo4j.repository.QueenRepository;
import com.example.neo4j.service.KingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author qiuyu
 * @date 2023年02月14日 15:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Neo4jApplication.class)
@TestPropertySource("/application.properties")
public class KingServiceTest {

    @Autowired
    private KingService kingService;

    @Autowired
    QueenRepository queenRepository;

    @Test
    @Rollback(false)
    public void saveKing() throws Exception {
        List<King> kingList = InitData.initKing();
        kingService.saveKing(kingList);
    }


    @Test
    public void saveQueen() throws Exception {
        List<Queen> queenList = InitData.initQueen();
        kingService.saveQueen(queenList);
    }

    @Test
    public void saveRelation() throws Exception {
        kingService.saveRelation("朱元璋", "朱棣");
        kingService.saveRelation("朱棣", "朱高炽");
    }

    @Test
    public void findKing(){
        King king =  kingService.findByName("朱棣");
        System.out.println(king.getName());
    }


    
    @Test
    public void deleteAll(){
        kingService.deleteAll();
        queenRepository.deleteAll();
    }

}
