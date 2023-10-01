# 근본(컴공) 없는 1조 ㅇ_<

팀장: 장재성
팀원: 김정한, 박수진, 손희진, 안세현, 장원경, 함재형

# 팀 좌우명

- 적당히 ~~대충~~ 하자. 돌아만 가도록. 싸우지 말자

# 💬 팀원 소개

- **장재성** `백앤드/팀장 산업정보시스템공학 / 전자정보공학(IT융합)`
    - 디지털 출신이지만 특기는 가야금  다재다능남
        - Spring 기반 프로젝트 경험 有 / Data 분석 및 크롤링 경험 有 / Computer Vision 프로젝트 경험 有
- **장원경**`백앤드 IT응용시스템공학`
    - isfp형 1호선 라인 다국적 외국인 담당녀
        - Spring 기반 프로젝트 경험 有 / 외부 API 연동 경험 有 / 안드로이드 스튜디오 경험 有 / Unity 기반 프로젝트 경험 有
- **안세현**`백앤드 스마트시스템소프트웨어학`
    - 송우 출신 1년 반 연속 신입 육성 전담반
        - DJango 기반 프로젝트 경험 有 / 안드로이드 스튜디오 기반 프로젝트 경험 有
- **손희진**`````백앤드 산업공학`(ITM)
    - 서울, 울산, 부산을 아우르는 패디큐어까지 예쁜 러블리녀
        - Spring 기반 프로젝트 경험 有 / 안드로이드 스튜디오 기반 프로젝트 경험 有 / Computer Vision 프로젝트 경험 有
- **박수진**`백앤드 전기전자공학`
    - 안산 출신 미백건치 매력녀
        - 안드로이드 스튜디오 기반 프로젝트 경험 有
- **김정한**`프론트앤드 에너지정보통신과`
    - 전기 전공 차도남이지만 내 여동생에겐 따뜻한 자상남
        - OpenSource 기반 JavaScript 개발 경험 有
- **함재형**``프론트앤드 전기공학 / 빅데이터융합`
    - 매일 130명의 고객을 상대하는 파워 은행원 함씨
        - Spring 기반 프로젝트 경험 有 / React 기반 프로젝트 경험 有 / 안드로이드 스튜디오 기반 개발 有

# ❗규칙

1. 싸우지 말자  (**절대로**)
2. 언성을 높이지 말자
3. 1주일 최소 1번 zoom 미팅을 진행하자(매주 일요일 夜)

# 👉프로젝트 기획안

---

# [**서비스명: 어디까지 알아보셨어요? aka. 어알 ]**

### 서울 **아파트 실거래가(KB시세)**를 바탕으로 신규 전세대출가능여부 조회 및 금융 상품 추천 시스템

→ 부동산 가격 kb 시세 평균가 이용하나 대략적인 **현재 API의 한계**로 인해 시세 활용, 고객에게 직접 KB시세 안내(링크 제공) 후 입력값으로 받아 한도 조회하고자 함.

## **서비스 구성 안내**

## **1. 서비스 소개**

- **기획 의도**
    - 고객이 내점하지 않고도 **서울 지역**의 지도 검색을 통해 대략적인 **전세**(**아파트**)대출 가능여부 및 대략적 금리 확인 가능하게 함. (KB시세로 고객이 바로 확인이 불가능 하므로 공공데이터포털 api 활용 현재 실거래가 안내, KB시세는 고객이 직접입력)
    
    → 실거래가와 실제 한도 산정 시 사용되는 kb부동산 시세 연결하는 **링크** 통해서, 차이를 고객에게 알 수 있도록 한다.
    
    → **실제 정확한 한도 산출을 원할 경우 kb시세 일반가, 본인의 소득** **를 직접 고객이 넣을 수 있도록 한다. (입력 값)**
    
    ![Untitled](./img/Untitled.png)
    
    당행 기준으로 취급한 전세대출 상품 內 가능 여부 간단하게 조회 가능
    
    - IBK전세대출 (SGI서울보증)
    - IBK안심전세대출(HUG)
    
- **문제 탐색(배경)**
    - 고객이 내점하여 “요즘 아파트담보대출 금리 어느정도 나와요?” 물어보는 경우가 많지만 즉각적인 답을 내놓기 힘듬.
    - 코로나 종식으로 인한 결혼 증가로 신혼 부부 아파트 구매를 원하는 고객 수요 층 증가
    - 가계부채 증가로 인해, 전세대출 상품 금리 감면이 작아질 것을 우려하여 빠르게 대출을 원하는 고객들 증가.
- **문제 정의**
    - 단순 금리 조회만을 위해 오랜시간 창구 대기가 필요.
    - 실제 임대인과 계약하기 전 가능 대출 가능 여부를 고객이 알기 힘듬
    - 전세계약서 작성 후 계약금을 지불했으나 잔금 대출이 가능한지 문의하는 경우가 많음.
    - 타행과의 전세대출 금리 비교를 위해 모든 은행을 방문해야 하는 불편함 존재.
    - 신규임차 자금 外 전세금을 담보로 생활안정자금을 요청하는 고객들 존재.
- **문제 해결**
    - 단순 문의 전화량 감소
    - 창구 혼잡도 감소
    - 개인여신 없는 1조에서 책임자 여신과목 합격률 상승

## **2. 서비스 주요 기능 설명 및 Usecase**

**웹서비스의 유용성, 편의성 및 시각화의 실용성에 대한 설명**

- **시세가 존재하는 아파트 전세 신규 대출 가능 여부 안내**
    - **체크리스트** 제공하여 가능여부를 회신 받고자 함.
    - **공통 체크리스트**
        - 공인중개업자를 통해 임대차계약 체결 임차보증금의 5%이상 계약금으로 지급 여부(Y)
        - 임대인 외국인 여부 (Y이면 취급 불가)
        - 임대인과 임차인 관계 배우자, 직계존비속, 형제자매 여부 (Y이면 대출 취급 불가)
        - 부부합산 주택보유수 1개 이하 & 투기지역-투기과열지구(강남,서초,송파,용산) 內 3억이하 아파트 20.7.10일 이후 미취득 여부 (Y여야만 실행 가능)
            
            → 규제지역 주택 보유 예외 사유 (직장이전, 자녀교육, 질병치료, 부모봉양, 학교폭력)로 인한 신청일 경우 영업점 문의 안내
            
            → 주택보유수 주택법 상 주택 및 복합용도 주택(등기상 “상가 및 주택”으로 등재) + 잔금대출이 확인되는 분양권(입주권) 부부 합산 개수 1개 이하여야 함.
            
        - 임대인이 임차목적물 소유 최소 3개월 진행 여부(N이면 진행 불가)
            
            → 예외 사항 존재하나 해당 경우 영업점 문의
            
    - **IBK전세대출(SGI서울보증)**
        - 임대차 기간 3개월 이상 3년 이내 여부 (N이면 취급 불가)
        - 민법상 성년 (IBK 전세) → 임차인 현재 나이 만 19세 이상인지 확인
        - 주택임대차보호법상 임차인 대항요건(입주 및 주민등록 전입) & 확정일자 갖추어 우선변제권 받을 수 있는가 → Y/N으로 고객 입력 받음 (Y여야만 실행 가능)
        - 소득대비 금융비용부담률(신청 건 포함) 40%이내인 고객 (DSR과 다름)
            - 고객이 연간 부담하는 대출이자(본 건 포함) / 고객의 연소득 X 100
            - 부부소득 합산 가능 BUT 이 경우 배우자 부채도 합산
        - 대출 신청일 기준 당타행 전세자금대출 보유 여부 (N이어야만 실행 가능)
        - 금융기관 신용관리대상자 여부(Y이면 취급 불가)
        - 임대인의 임차보증금반환채권 질권설정에 대한 승낙 가능 여부 (N이면 대출 취급 불가)
            - **대출 원하는 금액 및 신용점수 입력**
                - 다음 1,2,3,4 中 적은 금액으로 가능
                1. CB점수 별 한도
                
               ![Untitled](./img/Untitled2.png)
                
                1. 무주택자(부부합산) 최고 5억원 가능 & 1주택자(부부합산) 최고 3억원 가능
                2. 임대차계약서상 임차보증금의 80%이내여야 함.
                3. KB시세 매매일반평균가 * 0.8 - 선순위 채권 최고액 이내여야 신청 가능
    - **IBK안심전세대출(HUG)**
        - 임차보증금 7억 이내, 임대차 기간 1년 이상 계약 체결 여부 (N이면 실행 불가)
        - 전세금안심대출보증서 발급 및 권리보험 가입이 가능 여부 (N이면 실행 불가)
        - 보유 주택 매도 후 해당 주택 임차하려는 고객 여부 (Y 이면 실행 불가)
        - 임차물과 공인중개사 원격지 여부 (Y이면 실행 불가)
        - 계약일자와 잔금일 간의 기간이 14일 이내 여부(Y이면 실행 불가)
        - 임대차 기간 24개월 초과 여부( Y이면 실행 불가)
        - 선순위 채권: 주택가격(KB시세 일반가)의 80%이내일 것
        - 소유권 침해 여부(경매신청, 압류, 가압류, 가처분, 가등기 등) (Y이면 취급 불가)
            - 반환보증 한도 = 주택가격 X 담보인정비율(90%) - 선순위 채권 ( 임대인이 돈 안 줄 시 공사에서 임차인에게 돌려줄 수 있는 일종의 보험)
                - 단 전세보증금과 선순위채권의 합은 주택가액보다 작거나 같아야 함
                - 전세보증금 + 선순위 채권 ≤ 주택 가액
                - 반환 보증 최대한도 7억 (전세보증금을 넘어설 순 없음)
                
                ![Untitled](./img/Untitled3.png)
                
            - 특약보증 한도 (대출 신청 가능 금액)
                - 다음 1 ~ 5 중 적은 금액
                1. 전세보증금의 80%로 최대 4억 (예외 사항 영업점 문의. 신혼 부부 등)
                2. 반환보증금액의 80%
                3. 차주 CB점수별 대출 한도
                    1. KCB 805점 이상 또는 NICE 820점 이상 : 400백만
                    2. KCB 665점 이상 또는 NICE 740점 이상: 150백만
                    3. KCB 550점 이상 또는 NICE 670점 이상: 70백만
                4. 20.07.10 이후 임대차 계약을 체결한 1주택자의 경우: 최대 한도 2억
            
            ![Untitled](./img/Untitled4.png)
            
- 회원 정보 관리
    - 개인 이메일로 회원가입
    - 신용정보, 소득정보 저장 / 수정 (익명화 및 가명화 어려우므로 고객 직접입력 예정)
    - 개인정보 삭제 기능
- 서울 부동산 시세 조회 (KB 시세 조회 링크)
    - 시도 / 구군 구글 맵 활용하여 해당 위치 아파트 표기 (구글 map api 활용 예정)
    
    ![Untitled](./img/Untitled5.png)
    
    - 맵에 표기 된 매물 선택 시 , 가격, 면적, 거래일 등 상세 정보 표기
    
    ![Untitled](./img/Untitled6.png)
    
    - 관심있는 매물 위시리스트 추가
- 대출 가능한도 조회
: 회원 입력값(신용도, 소득 등)에 따른 대출 가능한도 산출( 위 체크리스트 기반)

![Untitled](./img/Untitled7.png)

- 당행 금융 상품 추천(IBK전세, IBK안심전세) 
: **은행연합회 대출금리 비교 페이지 크롤링 실제** 실행 금리 가져오기

[전국은행연합회 소비자포털](https://portal.kfb.or.kr/compare/loan_household_new.php)

## **3. 서비스 구성도**

![Untitled](./img/Untitled8.png)

- Spring Framework (Spring Boot) ver. 2.3.5
- WAS TomCat 8.0
- JAVA 1.8.0 , javac 1.8.0
- Vue.js (JavaScript)
- Mysql /  Amazon S3 (활용 예정)
- Amazon ec2

## **4. 프로젝트 팀원 역할 분담**

| 이름 | 담당 업무 |
| --- | --- |
| 장재성 | 팀장/백엔드 개발 |
| 손희진 | 백엔드 개발 |
| 장원경 | 백엔드 개발 |
| 안세현 | 백엔드 개발 |
| 함재형 | 프론트엔드 |
| 김정한 | 프론트엔드 |
| 박수진 | 백엔드 개발 |

[**멤버 별 responsibility]**

1. **장재성: 팀장/백엔드 담당**
- 기획 단계: 구체적인 설계와 지표에 따른 프로젝트 제안서 작성
- 개발 단계: 팀원 간의 일정 등 조율 + 백엔드 개발
- 수정 단계: 멘토 피드백 반영해서 수정, 발표 준비
1. **손희진 : 백엔드 담당**
- 기획 단계: 아이디어 구체화, 문서화
- 개발 단계 : 데이터 크롤링
- 수정 단계: 이슈리스트 작성 및 피드백 반영해서 백엔드 설계 수정
1. **장원경 : 백엔드 담당**
- 기획 단계: 아이디어 제공, 구체화
- 개발 단계: 데이터베이스 구축 및 데이터 관리
- 수정 단계: 이슈리스트 작성 및 피드백 반영해서 백엔드 설계 수정
1. **안세현 : 백엔드 담당**
- 기획 단계: 아이디어 제공, 구체화
- 개발 단계: 백엔드 기능 개발
- 수정 단계: 이슈리스트 작성 및 피드백 반영해서 백엔드 설계 수정
1. **함재형 : 프론트엔드 담당**
- 기획 단계: 아이디어 제공, 구체화
- 개발 단계: 웹페이지 개발
- 수정 단계: 이슈리스트 작성 및 피드백 반영해서 백엔드 설계 수정
1. **김정한 : 프론트엔드 담당**
- 기획 단계: 아이디어 제공, 구체화
- 개발 단계: 웹페이지 개발
- 수정 단계: 이슈리스트 작성 및 피드백 반영해서 백엔드 설계 수정
1. **박수진 : 백엔드 담당**
- 기획 단계: 아이디어 제공, 구체화
- 개발 단계: 백엔드 기능 개발
- 수정 단계: 이슈리스트 작성 및 피드백 반영해서 백엔드 설계 수정

## **5. 개발 타임라인(**⭐)

- 기능명세 작성 완료 (8/20)

[1조 기능명세서](https://docs.google.com/spreadsheets/d/1348EmYrbX67XjoG_UATYuroP7aOpAz8zXG-pK0iCC1w/edit#gid=0)
