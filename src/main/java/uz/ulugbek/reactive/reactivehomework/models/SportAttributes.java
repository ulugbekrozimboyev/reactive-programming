package uz.ulugbek.reactive.reactivehomework.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class SportAttributes {

    private String name;
    private String description;
    private String parent_id;
    private String decathlon_id;
    private String slug;
    private String locale;
    private List<String> weather;
    private String icon;

}
