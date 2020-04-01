package edu.cooper.ee.ece366.LusterCode.model;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

public class Module {
    // Instance Variables
    private final String name;
    private final List<Post> postList;
    private final Timestamp timestamp;
    static final AtomicLong NEXT_ID = new AtomicLong(0);
    final long moduleID = NEXT_ID.getAndIncrement();

    public Module(String name, List<Post> postList){
        this.name = name;
        this.postList = postList;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getName() { return name; }
    public List getPostList() { return postList; }
    public long getModuleID() {return moduleID; }
    public Timestamp getTime() { return timestamp; }


}