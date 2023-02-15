package com.example.neo4j.dto;

import java.util.List;

/**
 *
 *
 * @author qiuyu
 * @date 2023年02月14日 15:40
 */
public class GraphDTO {

    private List<Object> nodes;
    private List<Object> links;

    public List<Object> getNodes() {
        return nodes;
    }

    public void setNodes(List<Object> nodes) {
        this.nodes = nodes;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}
