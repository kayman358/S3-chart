/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s3.S3.controller;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.s3.S3.model.S3Object;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 
 */
@RestController
@RequestMapping("/api/v1")
public class S3Controller {
    
    @GetMapping("/getS3Objects")
    public List<S3Object> getS3Object() {
        
        List<S3Object> ls = new ArrayList<>();
               Regions clientRegion = Regions.EU_WEST_2;
        String bucket_name = "my-helm-chartzs";

        System.out.print("Objects in S3 bucket %s:\n" + bucket_name);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(clientRegion).build();
        ListObjectsV2Result result = s3.listObjectsV2(bucket_name);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        for (S3ObjectSummary os : objects) {
            S3Object obj = new S3Object();
            obj.setKey(os.getKey());
            ls.add(obj);
            
        }
        
        return ls;
    }
    
}
