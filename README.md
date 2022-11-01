# estudo_springsecurity

Estudando o spring security xml

## Spring Security 3.2.10.RELEASE

Ele necessita do commons-logging como dependencia.

É importado como dependencia transitiva libs do springframework 3.2.18.RELEASE

spring-aop

spring-beans

spring-context

spring-core

spring-expression

spring-web

## Evoluindo para utilizar o Spring Framework 5.3.23 com Spring Security 3.2.10.RELEASE

Sem impacto no spring security.

## Login personalizado

security.xml
```
<http auto-config="true" >

        <intercept-url pattern="/home.jsp" access="ROLE_USER,ROLE_ADMIN"/>
        <intercept-url pattern="/admin.jsp" access="ROLE_ADMIN"/>

        <form-login
                login-page="/login.jsp"
                default-target-url="/home.jsp"
                authentication-failure-url="/login?error"
                username-parameter="j_username"
                password-parameter="j_password" />

</http>
```

login.jsp
```
<form name="f" action="j_spring_security_check" method="POST">
<table>
    <tr><td>User:</td>
        <td><input type='text' name='j_username' value=''/></td>
    </tr>
    <tr><td>Password:</td>
        <td><input type='password' name='j_password'></td></tr>
    <tr>
        <td>
            <input type="checkbox" name="_spring_security_remember_me">
        </td>
        <td>Don't ask for my password for two weeks</td>
    </tr>

    <tr><td colspan='2'><input name="submit" type="submit"></td></tr>
    <tr><td colspan='2'><input name="reset" type="reset"></td></tr>
</table>
</form>
```

## Spring com somente uma sessão 

```
<http auto-config="true" use-expressions="true" >

    <form-login
            login-page="/login.jsp"
            default-target-url="/home.jsp"
            authentication-failure-url="/login.jsp?error" />

    <intercept-url pattern="/home.jsp" access="hasAnyRole('ROLE_USER','ROLE_ADMIN')"/>
    <intercept-url pattern="/admin.jsp" access="hasRole('ROLE_ADMIN')"/>

    <session-management>
        <concurrency-control max-sessions="1" />
    </session-management>

</http>
```