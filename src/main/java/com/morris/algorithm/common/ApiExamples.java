package com.morris.algorithm.common;

public class ApiExamples {

    public static final String ERROR_409_EXAMPLE =             """
            {
              "success": false,
              "code": 409,
              "message": "중복된 이메일입니다.",
              "data": null
            }
            """;

    private ApiExamples() {}

    public static final String ERROR_400_EXAMPLE =
            """
            {
              "success": false,
              "code": 400,
              "message": "잘못된 요청입니다.",
              "data": null
            }
            """;

    public static final String ERROR_401_EXAMPLE =
            """
            {
              "success": false,
              "code": 401,
              "message": "인증이 필요합니다.",
            """;

    public static final String ERROR_403_EXAMPLE =
            """
            {
              "success": false,
              "code": 403,
              "message": "접근 권한이 없습니다.",
              "data": null
            }
            """;

    public static final String ERROR_404_EXAMPLE =
            """
            {
              "success": false,
              "code": 404,
            """;

    public static final String ERROR_500_EXAMPLE =
            """
            {
              "success": false,
              "code": 500,
              "message": "서버 오류입니다.",
              "data": null
            }
            """;

    public static final String ERROR_503_EXAMPLE =
            """
            {
              "success": false,
              "code": 503,
              "message": "서버가 점검중입니다.",
            """;

    public static final String ERROR_503_EXAMPLE_WITH_DATA =
            """
            {
              "success": false,
              "code": 503,
            """;

    public static final String ERROR_404_EXAMPLE_WITH_DATA =
            """
            {
              "success": false,
              "code": 404,
              "data": null
            }
            """;

    public static final String ERROR_1004_EXAMPLE =
            """
            {
              "success": false,
              "code": 1004,
              "message": "사원 상태가 차단되었습니다."
            }
            """;

    public static final String ERROR_1001_EXAMPLE =
            """
            {
              "success": false,
              "code": 1001,
              "message": "삭제된 사원 정보입니다."
            }
            """;
}