package com.example.demo.service.constant;

import java.util.HashMap;

public class GrantConstants {

    public static final HashMap<String, String> GRANT_SCHEMES = new HashMap();
    static
    {
        GRANT_SCHEMES.put("A", "Student Encouragement Bonus");
        GRANT_SCHEMES.put("B", "Family Togetherness Scheme");
        GRANT_SCHEMES.put("C", "Elder Bonus");
        GRANT_SCHEMES.put("D", "Baby Sunshine Grant");
        GRANT_SCHEMES.put("E", "YOLO GST Grant");
    }

    private GrantConstants() {
    }
}
