package com.spring.ref.config.exception.handler;


import com.spring.ref.config.exception.RequestBasicInfo;
import com.spring.ref.config.exception.ResponseEntityBody;
import com.spring.ref.config.exception.RestException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice(annotations = RestController.class)
public class RestDefaultExceptionHandler {

  @NonNull
  private RequestBasicInfo requestBasicInfo;

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  protected ResponseEntity<ResponseEntityBody> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    ResponseEntityBody entity = ResponseEntityBody.builder()
      .path(requestBasicInfo.getPath())
      .uuid(requestBasicInfo.getUuid())
      .timestamp(requestBasicInfo.getTimestamp())
      .message(e.getMessage())
      .build();

    return new ResponseEntity<>(entity, HttpStatus.METHOD_NOT_ALLOWED);
  }


  /**
   *  javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
   *  HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
   *  주로 @RequestBody, @RequestPart 어노테이션에서 발생
   */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.error("handleMethodArgumentNotValidException", e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    /**
//     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
//     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
//     */
//    @ExceptionHandler(BindException.class)
//    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
//        log.error("handleBindException", e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    /**
//     * enum type 일치하지 않아 binding 못할 경우 발생
//     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
//     */
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
//        log.error("handleMethodArgumentTypeMismatchException", e);
//        final ErrorResponse response = ErrorResponse.of(e);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    /**
//     * 지원하지 않은 HTTP method 호출 할 경우 발생
//     */
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        log.error("handleHttpRequestMethodNotSupportedException", e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
//        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
//    }
//
//    /**
//     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
//     */
//    @ExceptionHandler(AccessDeniedException.class)
//    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
//        log.error("handleAccessDeniedException", e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.HANDLE_ACCESS_DENIED);
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.HANDLE_ACCESS_DENIED.getStatus()));
//    }
//
  @ExceptionHandler(RestException.class)
  protected ResponseEntity<ResponseEntityBody> restException(RestException e) {

    log.error("ControllerExceptionHandler[restException]" , e);

    return new ResponseEntity<>(ResponseEntityBody.error(requestBasicInfo , e), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ResponseEntityBody> exception(Exception e) {

    log.error("ControllerExceptionHandler[exception]" , e);
    log.info("requestBasicInfo:{}",requestBasicInfo);

    return new ResponseEntity<>(ResponseEntityBody.error(requestBasicInfo , e), HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
