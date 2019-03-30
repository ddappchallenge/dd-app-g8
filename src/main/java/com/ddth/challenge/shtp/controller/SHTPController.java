package com.ddth.challenge.shtp.controller;

import java.util.ArrayList;

import com.ddth.challenge.shtp.model.FormEdgesData;
import com.ddth.challenge.shtp.model.FormGraphData;
//import com.ddth.challenge.shtp.algorithm.ShortestPath;
import com.ddth.challenge.shtp.model.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SHTPController {

	private static String[] index;
	private static String[][] way;
	private static int[][] cost;
	private static int[][] distance;

	@PostMapping(value="/graph")
	public HttpStatus graph(@RequestBody FormGraphData data){
		index = data.getNodes();
		
		String[][] Way = new String[index.length][data.getEdges().length];
		int[][] Cost = new int[index.length][data.getEdges().length];
		int[][] Distance = new int[index.length][data.getEdges().length];
		
		int[] count = new int[index.length];
		
		for(FormEdgesData var_edges : data.getEdges()){	
			for(int i = 0; i < index.length; i++){
				if(var_edges.getFrom().equals(index[i])){
					Way[i][count[i]] = var_edges.getTo();
					Cost[i][count[i]] = var_edges.getCost();
					Distance[i][count[i]] = var_edges.getDistance();
					count[i] = count[i] + 1;
					break;
				}
			}
		}
		way = Way;
		cost = Cost;
		distance = Distance;
		
		// for(int i = 0; i < way.length; i++){
		// 	for(int j = 0; j < way[0].length; j++){
		// 		System.out.println(way[i][j]);
		// 	}
		// 	System.out.println();
		// }
		// for(int i = 0; i < distance.length; i++){
		// 	for(int j = 0; j < distance[0].length; j++){
		// 		System.out.println(distance[i][j]);
		// 	}
		// 	System.out.println();
		// }
		return HttpStatus.OK;
	}

	@GetMapping(value = "/graph/shortestPath")
	public ArrayList<String> getshortestPath(@RequestParam(value="src") String src, @RequestParam(value="dest") String dest){
		ResponseMessage hm = new ResponseMessage();
		ArrayList<String> xx2 = new ArrayList<String>();
		ArrayList<String[]> xx = new ArrayList<String[]>();
		for(int i = 0; i < index.length; i++){
			System.out.println(i);
			if(src.equals(index[i])){
				System.out.println(i);
				int c =0;
				String result = null;
				for(int x = 0; x < way[i].length; x++){

					xx2.add(index[i]);
					if(!way[i][x].equals(null)){
						xx2.add(way[i][x]);
						c=1;
						result = way[i][x];
						break;
					}
				}
				if(c==1	){
					break;
				}
				else{
					System.out.println("xx");
					i = -1;
					src = result;
				}
			}
		}
		
		return xx2;
	}

	// @ResponseStatus(HttpStatus.OK)
	// @GetMapping(value = "/hello")
	// public ResponseMessage helloGet(){
	// 	ResponseMessage hm = new ResponseMessage();
	// 	hm.setMessage(lastestMessage);
	// 	hm.setStatus("OK");
	// 	return hm;
	// }

	// @PostMapping(value="/set-hello-message")
	// public HttpStatus setResponseMessage(@RequestParam(value="message") String message){
	// 	lastestMessage = message;
	// 	return HttpStatus.OK;
	// }

	@GetMapping(value = "short")
	public String ShortestPath(){
		//ShortestPath a= new ShortestPath();
		return "Just a sample";
	}
}
