package group.msg.exercises;



import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@interface Censored {

     String replaceSwearWords(String received);
}
