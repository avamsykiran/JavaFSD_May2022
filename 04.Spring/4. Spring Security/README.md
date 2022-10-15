Authentication and Authorization

    Authentication is to verify and confirm the identity of the user. It is done using a
    public key (userid/username/emailId/mobile...etc) and a private key (PIN/Password/OTP...etc).
    Authentication on successful verification grants entry into the app.

    Authorization is to check if the authenticated user has a privilage or not. Privileage is
    access to one or moe resources or operations.

Authentication is done via a large variety of machanisims.

    1. Form based Authentication
    2. Token based Authentication
        ..........etc.,

    Form Based Authentication:
        the user Identity is accepted from a html form
        and that data is securly (in encrypted form ) is brought back to the server
        and on the server the data is varified and if success then it is
        maintianed in the session on the server. As long as the user keeps
        interacting with the server, the session lives and rememebrs him as 
        authenticated. and because of this after authentiction, the upcoming
        request baring that session id are concidered authenticated.

    Token Based Authentication
        the user Identity is accepted from a html form
        and that data is securly (in encrypted form ) is brought back to the server
        and on the server the data is varified and if success then a token is generated
        and issued to the user. this token has to be submitted along with each new request.
        the token is verified every time a request comes in.

        jwt - json web token
            is one of the most common token standard used in token based authentication .

            { header.payload.signature }

CSRF    -   Cross Site  Reference Forgery

        is enabled in case of dynamic web applications
        and is disbled in case of rest-api.

Spring Security Archetecture

    UserDetails
    UserDetailsService      loadUserByUserName(....)
    AuthenticationManager
    PasswordEncoder
    HttpSecurity
    WebSecurityConfigAdapter

            https   =   http + SSL (Secured Socket Layer)
