package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {

	public static String cryptoMethod(int[] a1,int[] a2, String original,int crypt) {
		
		String cryptolized = "";
		if(a1.length!=a2.length ) {
			return null;
		}
		else if (crypt <=0) {
			return null;
		}
		else if(a1.length!=original.length() || a2.length!=original.length()) {
			return null;
			
		}
		else {
			for(int i=0;i<a1.length;i++) {
				cryptolized += (char)(((original.charAt(i) - 'a' + (a1[i]*a2[i]*crypt))%26)+'a');
			}
			
			return cryptolized;
			
		}
		
	}
	// aaaaaa 5 fkpuze
	// aaaaaa 6 gmsyek
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7,8,9,10};
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        String toBeEncrypted = "aaaaaaaaaa";
        int cryptInt = 92;

        
        
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          System.out.println("heroku running or not!");

        
        String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          String s ;
          while (sc1.hasNext())
          {
            String input = sc1.next().replaceAll("\\s","");
            s = input;
          }

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
        
            
          String result = App.cryptoMethod(array1,array2,s,input2AsInt);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
