//PredictionController.java
package com.example.mlapi;

import hex.genmodel.easy.RowData;
import hex.genmodel.easy.prediction.MultinomialModelPrediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping
    public MultinomialModelPrediction predict(@RequestBody RowData rowData) {
        try {
            return predictionService.predict(rowData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Prediction failed");
        }
    }
}

