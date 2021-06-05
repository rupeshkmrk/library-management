package com.hcl.hacktohire;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Scanner;

@SpringBootTest
class HacktoHireApplicationTests {

	@Test
	void contextLoads() {
				//Write code here
				Scanner scan = new Scanner(System.in);
				int n = scan.nextInt();
				for(int j = 0; j < n;j++){
					String s = scan.nextLine();
					HashMap<Character,Integer> hm = new HashMap();
					int max = 1;
					char ch = 'z';
					for(int i = 0;i < s.length();i++){
						if(hm.containsKey(s.charAt(i))){
							int x = hm.get(s.charAt(i));
							hm.put(s.charAt(i),x+1);
							x= x+1;
							if(x > max && s.charAt(i) < ch){
								max = x;
								ch = s.charAt(i);
							}
						}else{
							hm.put(s.charAt(i),1);
						}

					}
					System.out.println(ch);
				}
			}


}
