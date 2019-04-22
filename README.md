# spring-oauth-permission-demo
Spring Security OAuth Permission Demo Application

## Get Token
```bash
$ curl demo:password@localhost:9091/oauth/token -d "grant_type=password&username=user&password=password" | jq '.'
```

## Get Token Result
```json
{
  "jti": "cbe621c4-f4b9-44a1-867a-5163375a1902",
  "scope": "read write",
  "expires_in": 599999999,
  "token_type": "bearer",
  "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoyMTUzMDI0MjE4LCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiY2JlNjIxYzQtZjRiOS00NGExLTg2N2EtNTE2MzM3NWExOTAyIiwiY2xpZW50X2lkIjoiZGVtbyIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.CZEBl-P5RY_9pTKYb2rbs2lF3nL-p6d3EqyYSWj_1Abf8u1auq6hU2fT4VYKbe7zal3QLDi5w_BhMXu8J8V0D929o58Z9lEiWnuzDf0-NcdFYY0zgccvbRK0z35bISTnkSSkqd_Wws0B0hV3JiR7cV1SYebBGAVRpeVpAo-i-V5ZOFltvBN2pA2ZPlg1y-gDHeFJBVmivxSm6OJjDjBEJXdDqB0atnW1yde-pVR5wI0AtdTSZWP0k3DAE0D5tnyLIi8SgaMU99Px_jJrWE-lpxIn0YcnA0Es2vV4o-HJYopLSPj_Rp7_8bryFSWQ38c6NS_TXS3mynn5hhTTF5p89g"
}
```


## Extract Token and do Client Call with user_0500
```bash
$ TOKEN=$(curl demo:password@localhost:9091/oauth/token -d "grant_type=password&username=user_0500&password=password" | jq '.access_token' | sed 's/"//g') 
$ curl -H "Authorization: Bearer $TOKEN" localhost:9090
```

