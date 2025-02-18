package br.com.nlw.events.service;

import br.com.nlw.events.model.Event;
import br.com.nlw.events.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;

    public Event addNewEvent(Event event) {
        // gerando o preety name
        // ao criar um novo evento pegamos o nome do evento, transformamos tudo em minusculo
        // e substituimos os espaços por hífen ( - ) para gerar um nome amigável.
        // Por exemplo, "Meu Evento" vira "meu-evento" e salvamos isso utilizando os metodos
        // save() que vem do nosso repositorio que extende de CrudRepository que vem
        // do Spring Data JPA.
        event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ", "-"));
        return eventRepo.save(event);
    }

    public List<Event> getAllEvents() {
        // retornando todos os eventos salvos no repositorio, que extende de CrudRepository e convertendo
        // esse Iterable para uma lista usando o metodo findAll() do Spring Data JPA.
        // findAll() retorna um Iterable, então precisamos converter para uma lista utilizando o cast
        // (List<Event>).
        return (List<Event>)eventRepo.findAll();
    }

    public Event getByPrettyName(String prettyName) {
     // retornando um evento pelo nome amigável (prettyName), que é gerado pelo método
        return eventRepo.findByPrettyName(prettyName);
    }
}
