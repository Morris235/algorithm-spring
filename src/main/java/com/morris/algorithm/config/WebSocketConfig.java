
package com.morris.algorithm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket 설정 클래스
 * 알고리즘 시각화를 위한 실시간 통신 설정
 *
 * 주요 기능:
 * 1. 정렬 알고리즘 단계별 실시간 업데이트
 * 2. 그래프 탐색 경로 실시간 표시
 * 3. 학습 진도 실시간 알림
 * 4. 다중 사용자 학습 세션 지원
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * STOMP 엔드포인트 설정
     * 클라이언트가 WebSocket 서버에 연결할 때 사용하는 엔드포인트
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 알고리즘 시각화 전용 엔드포인트
        registry.addEndpoint("/ws/algorithm")
                .setAllowedOriginPatterns("*") // CORS 설정 (개발환경용)
                .withSockJS(); // SockJS 폴백 지원

        // 학습 대시보드 전용 엔드포인트
        registry.addEndpoint("/ws/dashboard")
                .setAllowedOriginPatterns("*")
                .withSockJS();

        // 문제 풀이 협업 기능용 엔드포인트
        registry.addEndpoint("/ws/collaboration")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    /**
     * 메시지 브로커 설정
     * 클라이언트 간 메시지 라우팅을 위한 브로커 구성
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 심플 브로커 활성화 - 메모리 기반 메시지 브로커
        registry.enableSimpleBroker(
                "/topic",    // 1:N 브로드캐스트 (알고리즘 시각화 단계 전송)
                "/queue",    // 1:1 개인 메시지 (개인 학습 알림)
                "/user"      // 사용자별 개인 채널
        );

        // 클라이언트에서 서버로 메시지를 보낼 때 사용할 prefix
        registry.setApplicationDestinationPrefixes("/app");

        // 사용자별 개인 메시지 prefix
        registry.setUserDestinationPrefix("/user");
    }

    /**
     * WebSocket 전송 관련 설정
     */
    @Override
    public void configureWebSocketTransport(org.springframework.web.socket.config.annotation.WebSocketTransportRegistration registry) {
        registry.setMessageSizeLimit(64 * 1024)    // 메시지 크기 제한 (64KB)
                .setSendBufferSizeLimit(512 * 1024) // 전송 버퍼 크기 (512KB)
                .setSendTimeLimit(20 * 1000);       // 전송 시간 제한 (20초)
    }
}