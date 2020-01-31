package microservices.multiplication.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.multiplication.domain.MultiplicationResultAttempt;
import microservices.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 사용자가 POST 로 답안을 전송하도록 REST API 를 제공하는 클래스
 */
@RestController
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

  private final MultiplicationService multiplicationService;

  @Autowired
  MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
    this.multiplicationService = multiplicationService;
  }

  @PostMapping
  ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
    return ResponseEntity.ok(
            new ResultResponse(multiplicationService
                    .checkAttempt(multiplicationResultAttempt)));
  }

  @RequiredArgsConstructor
  @NoArgsConstructor(force = true)
  @Getter
  static final class ResultResponse {
    private final boolean correct;
  }
}