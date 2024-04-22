import com.cityList.dto.Res;
import com.cityList.dto.Target;
import com.cityList.mapper.ObjectMapper;
import com.cityList.mapper.ObjectMapperImpl;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MapperTest {
    @Test
    void checkMapping(){

        Res res = new Res();
        res.setFirstName("Oleksandr");
        res.setLastName("Stepurko");
        res.setAge(40);
        res.setHeight(1.85);


        ObjectMapper mapper = new ObjectMapperImpl();

       Target target = mapper.toTarget(res, 18L);

        System.out.println(target);
    }

    @Test
    void checkMappingList(){

        Res res = new Res();
        res.setFirstName("Oleksandr");
        res.setLastName("Stepurko");
        res.setAge(40);
        res.setHeight(1.85);


        ObjectMapper mapper = new ObjectMapperImpl();

        List<Target> target = mapper.toTargets(List.of(res, res, res, res));

        System.out.println(target);
    }

}
