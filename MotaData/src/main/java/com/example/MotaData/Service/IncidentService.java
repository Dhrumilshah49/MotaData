package com.example.MotaData.Service;

import com.example.MotaData.Entity.IncidentEntity;
import com.example.MotaData.Repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IncidentService {

    @Autowired
    IncidentRepository repository;

    public IncidentEntity createIncident(IncidentRequest req) {

        String category = categorize(req.getDescription());
        String severity = detectSeverity(req.getDescription());

        IncidentEntity incident = new IncidentEntity();
        incident.setTitle(req.getTitle());
        incident.setDescription(req.getDescription());
        incident.setCategory(category);
        incident.setSeverity(severity);
        incident.setTimestamp(LocalDateTime.now());

        return repository.save(incident);
    }

    private String categorize(String desc) {
        if (desc.contains("database")) return "Database";
        if (desc.contains("network")) return "Network";
        return "General";
    }

    private String detectSeverity(String desc) {
        if (desc.contains("down") || desc.contains("critical")) return "Critical";
        if (desc.contains("slow")) return "Medium";
        return "Low";
    }

    public List<IncidentEntity> getAllIncidents() {
        return repository.findAll();
    }
}
