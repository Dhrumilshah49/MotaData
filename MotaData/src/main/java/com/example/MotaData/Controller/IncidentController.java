package com.example.MotaData.Controller;

import com.example.MotaData.Entity.IncidentEntity;
import com.example.MotaData.Service.IncidentRequest;
import com.example.MotaData.Service.IncidentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private static final Logger log = LogManager.getLogger(IncidentController.class);

    @Autowired
    IncidentService service;

    @PostMapping
    public ResponseEntity<IncidentEntity> create(@RequestBody IncidentRequest req){

//        Curl to trigger this endpoint
//        curl -X POST http://localhost:8080/api/incidents \
//        -H "Content-Type: application/json" \
//        -d '{
//        "title": "Database server down",
//                "description": "The database server is completely down and needs urgent fix."
//    }'


//        response :-{
//                "id": 2,
//                "title": "Database server down",
//                "description": "The database server is completely down and needs urgent fix.",
//                "category": "Database",
//                "severity": "Critical",
//                "timestamp": "2025-06-02T22:34:27.977"
//}


            log.info("In Post Request");
        IncidentEntity saved = service.createIncident(req);
        log.info(saved.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<IncidentEntity> getAll() {

//        Curl to trigger this endpoint
//        curl --location --request GET 'http://localhost:8080/api/incidents' \
//        --header 'Content-Type: application/json' \
//        --data-raw '{
//        "title": "Database server down",
//                "description": "The database server is completely down and needs urgent fix."
//    }'

//        response :-[
//        {
//            "id": 1,
//                "title": "Database server down",
//                "description": "The database server is completely down and needs urgent fix.",
//                "category": "Database",
//                "severity": "Critical",
//                "timestamp": "2025-06-02T22:30:34"
//        },
//        {
//            "id": 2,
//                "title": "Database server down",
//                "description": "The database server is completely down and needs urgent fix.",
//                "category": "Database",
//                "severity": "Critical",
//                "timestamp": "2025-06-02T22:34:27"
//        }
//]
        return service.getAllIncidents();
    }

}
