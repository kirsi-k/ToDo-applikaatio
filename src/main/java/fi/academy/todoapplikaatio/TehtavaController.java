package fi.academy.todoapplikaatio;

import fi.academy.todoapplikaatio.dao.TehtavaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/todot")
public class TehtavaController {
    private TehtavaDao tehtavaDao;

    @Autowired
    public TehtavaController(@Qualifier("jdbc") TehtavaDao tehtavaDao) {
        this.tehtavaDao = tehtavaDao;
    }
    @GetMapping("")
    public List<Tehtava> listaaKaikkiTehtavat() {
        List<Tehtava> todolista = tehtavaDao.haeKaikki();
        return todolista;
    }
    @PostMapping("")
    public ResponseEntity<?> lisaaUusiTehtava(@RequestBody Tehtava tehtava){
        int id = tehtavaDao.lisaa(tehtava);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).body(tehtava);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> poistaTehtava(@PathVariable int id){
        Tehtava poistettu = tehtavaDao.poista(id);
        if (poistettu != null)
            return ResponseEntity.ok(poistettu);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(String.format("Tehtävää ei löydetty, ei voitu poistaa. Tarkista id:", id));
    }
}
