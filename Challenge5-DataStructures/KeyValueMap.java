//UIUC CS125 FALL 2012 MP. File: KeyValueMap.java, CS125 Project: Challenge5-DataStructures, Version: 2012-10-12T13:24:10-0500.281837000
/**@author lzhou8*/

import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map
	
	private String[] thekey=new String [0];
	
	private Color[] thevalue=new Color [0];

	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	public void add(String key, Color value) {
		String[] tmpk= new String[thekey.length+1];
		Color[] tmpv= new Color[thevalue.length+1];
		for (int i=0;i<thekey.length;i++)
			if (key==thekey[i])thekey[i]=key;
			else tmpk[i+1]=thekey[i];
		tmpk[0]=key;
		thekey=tmpk; 
		for (int i=0;i<thevalue.length;i++)
			tmpv[i+1]=thevalue[i];
		tmpv[0]=value;
		thevalue=tmpv; 
		//throw new RuntimeException("Hi");
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		int n=0;
		Color[] tmp= new Color[1];
		for (int i=0;i<thekey.length;i++){
			if (key.equals(thekey[i]))
			    tmp[0]=thevalue[i];
			n++;}
		if(n==0) return null;
		return tmp[0];
		
		//throw new RuntimeException("Ho");
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		boolean flag=false;
		for (int i=0;i<thekey.length;i++){
			if (key.equals(thekey[i]))
				flag=!flag;}
		return flag;
		
		//throw new RuntimeException("Hi");
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		String[] tmpk= new String[thekey.length-1];
		Color[] tmpv= new Color[thevalue.length-1];
		int n=0;
		for (int i=0;i<thekey.length-1;i++)
				tmpk[i]=thekey[i];
		thekey=tmpk; 
        
		for (int i=0;i<thekey.length-1;i++)
			tmpv[i]=thevalue[i];
		thevalue=tmpv; 
		//throw new RuntimeException("Ho");
	}

}
