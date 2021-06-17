package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

@Service
public class AccumulationManager {
    private AccumulationRepository repository;

    public AccumulationManager(AccumulationRepository repository) {
        this.repository = repository;
    }

    public void accumulate() {
        createAccumulation();
        Accumulation accumulation = increaseAccumulation();
        repository.save(accumulation);
        System.out.println("Times that the countdown went off: " + accumulation.getTimes());
    }

    private void createAccumulation() {
        if (repository.count() == 0) {
            Accumulation accumulation = new Accumulation(0);
            repository.save(accumulation);
        }
    }

    private Accumulation increaseAccumulation() {
        Accumulation accumulation = repository.findAll().get(0);
        int times = accumulation.getTimes();
        accumulation.setTimes(times + 1);
        return accumulation;
    }
}
