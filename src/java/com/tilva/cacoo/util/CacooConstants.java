/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tilva.cacoo.util;

/**
 *
 * @author mtilva
 */
public class CacooConstants {
    
    public static final String API_BASE = "https://cacoo.com/api";
    public static final String API_VER = "/v1";
    
    //for single diagram.
    public static final String DIAGRAM_API =  "/diagrams";
  
    //for all diagrams
    public static final String DIAGRAMS_API ="/diagrams";
    
    public class DIAGRAMS_JSON{
        public static final String RESULT_ARRAY = "result";
    
        public static final String IMAGE_URL = "imageUrl";
        public static final String URL = "url";
        public static final String DIAGRAM_ID = "diagramId";
        public static final String TITLE = "title";  
        public static final String DESCRIPTION = "description";
        public static final String FOLDERID = "folderId";   
        //Add other values too.
                 
   }
}
