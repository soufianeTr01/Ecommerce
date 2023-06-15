package org.sid.Ecommerce.Services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrServices {
    String  savePhoto(InputStream photo, String title) throws FlickrException;

}
