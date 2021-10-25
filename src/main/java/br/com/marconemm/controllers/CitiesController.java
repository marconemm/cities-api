package br.com.marconemm.controllers;

import br.com.marconemm.models.City;
import br.com.marconemm.services.CitiesService;
import br.com.marconemm.utils.ResponseSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/V1/cities")
public class CitiesController {

    @Autowired
    private CitiesService citiesService;

    @GetMapping("/pageable")
    public Page<City> getAllByPage(Pageable page) {
        return citiesService.getAllByPage(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getByCode(@PathVariable Integer id) {
        ResponseSerializer<City> serializer = new ResponseSerializer<>();

        if (id < 1 || id > 5609) {
            final City invalidCity = new City();
            serializer.setMsg("Invalid ID informed.");
            serializer.setStatus(HttpStatus.BAD_REQUEST);

            return serializer.toJSON();
        }

        final Optional<City> result = citiesService.getByID(id);
        serializer.setData(result.get());
        serializer.setStatus(HttpStatus.OK);

        return serializer.toJSON();
    }

    @GetMapping("/getDistance")
    public Float getDistanceBetween(@RequestParam(name = "cityId_1") Integer cityId1,
                                    @RequestParam(name = "cityId_2") Integer cityId2){

        System.out.println(cityId1);
        System.out.println(cityId2);

        return 0f;
    }
}
