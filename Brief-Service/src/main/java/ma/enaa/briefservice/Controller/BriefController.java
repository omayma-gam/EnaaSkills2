package ma.enaa.briefservice.Controller;

import ma.enaa.briefservice.Services.BriefService;
import ma.enaa.briefservice.dto.BriefDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brief")
public class BriefController {
    private final BriefService briefService;

    public BriefController(BriefService briefService) {
        this.briefService = briefService;
    }
    @PostMapping
    private BriefDto Add(@RequestBody BriefDto dto){
        return briefService.creerBrief(dto);
    }

    @GetMapping
    private List<BriefDto> get(){
        return  briefService.List();
    }
    @PutMapping("{id}")
    private BriefDto udate(@PathVariable Long id,@RequestBody BriefDto briefDto){
        return briefService.ModifierBrief(id,briefDto);
    }
    @DeleteMapping("{id}")
    private void Dlete(@PathVariable Long id){
        briefService.SupprimerBrief(id);
    }
}
