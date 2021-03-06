package microservices.gamification.controller;

import microservices.gamification.domain.LeaderBoardRow;
import microservices.gamification.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Gamification 리더보드 서비스의 REST API
 */
@RestController
@RequestMapping("/leaders")
class LeaderBoardController {

  private final LeaderBoardService leaderBoardService;

  public LeaderBoardController(final LeaderBoardService leaderBoardService) {
    this.leaderBoardService = leaderBoardService;
  }

  @GetMapping
  public List<LeaderBoardRow> getLeaderBoard() {
    return leaderBoardService.getCurrentLeaderBoard();
  }
}
