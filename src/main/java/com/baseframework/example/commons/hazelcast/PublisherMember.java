package com.baseframework.example.commons.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;


public class PublisherMember {

    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        ITopic<String> topic = hz.getTopic("topic");
        topic.publish("Hello HazelCast");
    }
}
