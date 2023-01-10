package notifications.boldo.py.org.pti;

import io.jsonwebtoken.*;

public class JsonWebToken {

  private Jwt<Header, Claims> jwt;

  public JsonWebToken(String authorizationHeader) {
    var token = authorizationHeader.split(" ")[1];
    var tokenWithoutSignature = token.substring(0, token.lastIndexOf('.') + 1);
    try {
      jwt = Jwts.parserBuilder()
        .setAllowedClockSkewSeconds(5 * 60) // 5 minutes
        .build()
        .parseClaimsJwt(tokenWithoutSignature);
    } catch (ExpiredJwtException e) {

      // We don't care if the JWT expired. We parse it anyway. Other types of exceptions, listed
      // in https://javadoc.io/doc/io.jsonwebtoken/jjwt-api/latest/io/jsonwebtoken/JwtParser.html
      // are thrown and will cause a 500 Internal Server Error. That's ok in my opinion because the
      // causes of the exceptions should be fixed internally in the health-core API or in the
      // KeyCloak server.
      jwt = new Jwt<>() {
        @Override public Header getHeader() {
          return e.getHeader();
        }

        @Override public Claims getBody() {
          return e.getClaims();
        }
      };

    }
  }

  public String getName() {
    return getClaim("preferred_username");
  }

  public String getClaim(String claim) {
    return jwt.getBody().containsKey(claim) ? jwt.getBody().get(claim).toString() : null;
  }
}