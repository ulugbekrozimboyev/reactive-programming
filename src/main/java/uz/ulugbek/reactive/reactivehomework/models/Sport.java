package uz.ulugbek.reactive.reactivehomework.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document
public class Sport {

    private String id;
    private String type;
    private SportAttributes attributes;


}
