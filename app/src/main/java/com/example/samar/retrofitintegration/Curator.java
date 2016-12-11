package com.example.samar.retrofitintegration;

import java.util.List;

/**
 * Created by samar on 11/12/16.
 */

public class Curator {
    public String title;
    public List<Dataset> dataset;

    public class Dataset{
        String curator_title;
        String curator_tagline;
    }
}
