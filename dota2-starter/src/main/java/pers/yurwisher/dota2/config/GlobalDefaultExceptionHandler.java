package pers.yurwisher.dota2.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import pers.yurwisher.dota2.common.enums.tip.RBACCustomTipEnum;
import pers.yurwisher.wisp.enums.CustomTipEnum;
import pers.yurwisher.wisp.exception.CustomException;
import pers.yurwisher.wisp.utils.CollectionUtils;
import pers.yurwisher.wisp.utils.StringUtils;
import pers.yurwisher.wisp.wrapper.R;

import java.util.List;
import java.util.Optional;

/**
 * controller  全局异常回调
 * @author yq on 2016/06/15 10:25.
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * 全局异常
     */
    @ExceptionHandler(Exception.class)
    public R defaultErrorHandler(Exception e){
        logger.error(e.getMessage(),e);
        return  R.fail(CustomTipEnum.ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e){
        List<FieldError> errors =  e.getBindingResult().getFieldErrors();
        if(CollectionUtils.isNotEmpty(errors)){
            Optional<FieldError> optional =  errors.stream().filter(error -> StringUtils.isNotEmpty(error.getDefaultMessage())).findFirst();
            return optional.map(fieldError -> R.fail(fieldError.getDefaultMessage())).orElseGet(() -> R.fail(CustomTipEnum.ERROR));
        }else {
            logger.error("自定义校验错误...",e);
            return  R.fail(CustomTipEnum.ERROR);
        }
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R httpRequestMethodNotSupportedExceptionHandle(HttpRequestMethodNotSupportedException e){
        return  R.fail(CustomTipEnum.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public R httpMediaTypeNotSupportedExceptionHandle(HttpMediaTypeNotSupportedException e){
        return  R.fail(CustomTipEnum.UNSUPPORTED_MEDIA_TYPE);
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public R noHandlerFoundExceptionHandle(NoHandlerFoundException e){
        return  R.fail(CustomTipEnum.NOT_FOUND);
    }

    /**
     * 自定义异常回调
     */
    @ExceptionHandler(CustomException.class)
    public R customExceptionHandler(CustomException e){
        return  R.fail(e.tip());
    }

    /**
     * 自定义异常回调
     */
    @ExceptionHandler(AccessDeniedException.class)
    public R accessDeniedExceptionHandler(AccessDeniedException e){
        return  R.fail(RBACCustomTipEnum.USER_ACCESS_DENIED);
    }

}
