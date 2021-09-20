package com.kaganarmagan.hititinterviewassignment.ajax;

import com.kaganarmagan.hititinterviewassignment.dto.CustomerListDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class AjaxResponseBody {

    String msg;
    List<CustomerListDTO> result;



}