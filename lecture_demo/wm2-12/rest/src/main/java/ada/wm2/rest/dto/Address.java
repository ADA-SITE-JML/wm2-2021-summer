
package ada.wm2.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;

}
