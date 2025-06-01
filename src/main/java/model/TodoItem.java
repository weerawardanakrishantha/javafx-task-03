package model;

import com.mysql.cj.conf.StringProperty;
import javafx.scene.control.CheckBox;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoItem {
    private String name;
    private CheckBox box;

}
