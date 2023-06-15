package org.sid.Ecommerce.Services.ServiceImpl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Services.FlickrServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@Service
@Slf4j
public class FlickrServicesImpl implements FlickrServices {

    @Autowired
    private Flickr flickr;

    public FlickrServicesImpl(Flickr flickr) {
        this.flickr = flickr;
    }

    @Override
    public String savePhoto(InputStream photo, String title) throws FlickrException {
        UploadMetaData uploadMetaData=new UploadMetaData();
        uploadMetaData.setTitle(title);
        String PhotoId=flickr.getUploader().upload(photo,uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(PhotoId).getMedium640Url();
    }

}
