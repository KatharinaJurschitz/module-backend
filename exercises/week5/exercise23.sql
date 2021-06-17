SELECT * FROM results r LEFT JOIN exercises e ON r.exerciseId=e.id WHERE r.result IS null AND e.id = "ex03";
