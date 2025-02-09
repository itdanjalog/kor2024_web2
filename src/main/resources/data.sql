-- member sample
insert into member (mid, mpwd, mname, memail, mimg, cdate, udate)
values
("qwe123", "a123456", "유재석", "qwe123@naver.com", "default.jpg", now(), now()),
("asd123", "b123456", "강호동", "asd123@naver.com", "default.jpg", now(), now()),
("zxc123", "c123456", "신동엽", "zxc123@naver.com", "default.jpg", now(), now()),
("vbn123", "d123456", "서장훈", "vbn123@naver.com", "default.jpg", now(), now()),
("rty123", "e123456", "하하", "rty123@naver.com", "default.jpg", now(), now());

-- point sample
insert into point (pcontent, pcount, mno, cdate, udate)
values
("회원가입축하", 100, 1, now(), now()),
("로그인", 1, 1, now(), now()),
("아이템구매", -50, 1, now(), now()),
("포인트구매", 2000, 1, now(), now()),
("아이템구매", 1000, 1, now(), now());

-- category sample
insert into category (cname, cdate, udate)
values
("뉴스", now(), now()),
("이벤트", now(), now()),
("FAQ", now(), now()),
("튜토리얼", now(), now()),
("사용자 리뷰", now(), now());

-- board sample
INSERT INTO board (btitle, bcontent, mno, cno, bview, cdate, udate) VALUES
("최신 스마트폰 비교 분석", "2025년 출시된 최신 스마트폰 모델을 비교 분석해보았습니다.", 1, 1, 320, now(), now()),
("여름 휴가 추천 여행지", "2025년 여름을 맞이하여 떠나기 좋은 국내외 여행지를 추천합니다.", 2, 1, 285, now(), now()),
("온라인 교육 트렌드 변화", "비대면 교육이 증가함에 따라 변화하는 온라인 교육 트렌드를 알아봅니다.", 3, 1, 198, now(), now()),
("자율주행 자동차의 미래", "AI 기반 자율주행 자동차의 발전 방향과 미래 전망을 분석합니다.", 4, 1, 412, now(), now()),
("IT 기업 채용 공고 모음", "유망 IT 기업들의 최신 채용 정보를 한눈에 확인하세요.", 5, 1, 623, now(), now()),
("환경을 위한 친환경 제품", "일상 속에서 실천할 수 있는 친환경 제품들을 소개합니다.", 1, 1, 310, now(), now()),
("건강한 식습관 가이드", "균형 잡힌 영양 섭취를 위한 건강한 식습관을 알려드립니다.", 2, 1, 501, now(), now()),
("최신 노트북 성능 비교", "2025년형 최신 노트북 성능을 비교하여 추천 제품을 선정했습니다.", 3, 1, 438, now(), now()),
("스타트업 투자 트렌드", "2025년 스타트업 투자 트렌드와 성공적인 투자 전략을 공유합니다.", 4, 1, 290, now(), now()),
("게임 업계 동향 분석", "2025년 상반기 게임 시장의 주요 트렌드를 살펴봅니다.", 5, 1, 722, now(), now()),
("우주 탐사 최신 소식", "최근 진행된 우주 탐사 프로젝트와 그 성과를 소개합니다.", 1, 1, 330, now(), now()),
("직장인을 위한 시간 관리 팁", "효율적인 시간 관리를 위한 실용적인 팁을 공유합니다.", 2, 1, 278, now(), now()),
("AI 기반 번역 기술 발전", "AI 기반 번역 기술의 최신 연구 동향과 발전 가능성을 분석합니다.", 3, 1, 195, now(), now()),
("가상현실(VR)과 증강현실(AR) 비교", "가상현실과 증강현실 기술의 차이점과 활용 사례를 알아봅니다.", 4, 1, 502, now(), now()),
("비즈니스 협상 전략", "성공적인 비즈니스 협상을 위한 실전 전략을 소개합니다.", 5, 1, 370, now(), now()),
("기후 변화와 지속 가능한 발전", "기후 변화에 대응하는 지속 가능한 발전 전략을 분석합니다.", 1, 1, 690, now(), now()),
("자동차 시장 최신 뉴스", "2025년 자동차 시장의 변화와 주요 모델들을 살펴봅니다.", 2, 1, 441, now(), now()),
("홈트레이닝 추천 운동", "집에서 쉽게 따라 할 수 있는 홈트레이닝 운동법을 소개합니다.", 3, 1, 289, now(), now()),
("전기차 충전 인프라 확대", "전기차 충전소 확장 계획과 관련 산업 전망을 살펴봅니다.", 4, 1, 375, now(), now()),
("인공지능이 바꾸는 직업 시장", "AI 기술이 직업 시장에 미치는 영향과 미래 직업 전망을 분석합니다.", 5, 1, 562, now(), now()),
("최신 드라마 리뷰", "2025년 방영된 인기 드라마를 리뷰하고 추천합니다.", 1, 1, 410, now(), now()),
("온라인 마케팅 성공 사례", "성공적인 온라인 마케팅 사례를 분석하고 인사이트를 제공합니다.", 2, 1, 488, now(), now()),
("데이터 사이언스 실전 활용", "데이터 분석 기법을 활용한 실전 사례를 공유합니다.", 3, 1, 310, now(), now()),
("로봇 기술 발전과 미래", "로봇 기술이 우리 생활에 미치는 영향을 분석합니다.", 4, 1, 612, now(), now()),
("메타버스의 현재와 미래", "메타버스 기술의 현황과 미래 발전 방향을 살펴봅니다.", 5, 1, 487, now(), now()),
("스마트 홈 기술 최신 동향", "스마트 홈 기술과 IoT를 활용한 혁신적인 제품들을 소개합니다.", 1, 1, 312, now(), now()),
("해외 취업 성공 가이드", "해외 취업을 위한 준비 과정과 성공 전략을 안내합니다.", 2, 1, 278, now(), now()),
("개발자를 위한 생산성 툴", "개발자들이 효율적으로 일할 수 있도록 돕는 생산성 툴을 소개합니다.", 3, 1, 399, now(), now()),
("한국 전통 음식 소개", "한국의 전통 음식을 소개하고 그 유래를 알아봅니다.", 4, 1, 285, now(), now()),
("재테크 초보자를 위한 가이드", "재테크를 시작하는 초보자를 위한 기초 가이드를 제공합니다.", 5, 1, 572, now(), now());

insert into board (btitle, bcontent, mno, cno, bview, cdate, udate)
values
("회원 가입 이벤트!", "회원 가입 시 포인트 500점을 지급하는 이벤트가 시작되었습니다. 지금 가입하고 혜택을 누리세요!", 1, 2, 120, now(), now()),
("친구 초대 이벤트", "친구를 초대하고, 친구가 첫 구매 시 보너스 포인트를 지급하는 이벤트를 진행 중입니다.", 2, 2, 255, now(), now()),
("구매 후 리뷰 작성 이벤트", "구매 후 리뷰를 작성하면 포인트를 추가로 지급하는 이벤트에 참여하세요.", 3, 2, 678, now(), now()),
("기프트 카드 추첨 이벤트", "기프트 카드 추첨 이벤트에 참여하고, 행운을 잡으세요!", 4, 2, 450, now(), now()),
("여름 세일 이벤트", "여름 시즌 제품을 최대 50% 할인하는 세일 이벤트를 놓치지 마세요!", 5, 2, 800, now(), now());

insert into board (btitle, bcontent, mno, cno, bview, cdate, udate)
values
("회원 가입 방법 안내", "회원 가입 절차에 대한 자세한 설명을 드립니다.", 1, 3, 550, now(), now()),
("비밀번호 변경 방법", "비밀번호를 안전하게 변경하는 방법에 대해 설명드립니다.", 2, 3, 900, now(), now()),
("배송 조회 방법", "구매한 상품의 배송 현황을 확인하는 방법을 안내드립니다.", 3, 3, 650, now(), now()),
("포인트 사용 방법", "적립된 포인트를 사용하는 방법을 알아봅니다.", 4, 3, 430, now(), now()),
("상품 반품 절차", "상품 반품 및 환불 절차에 대한 정보를 제공합니다.", 5, 3, 320, now(), now());

insert into board (btitle, bcontent, mno, cno, bview, cdate, udate)
values
("HTML5 기초 튜토리얼", "HTML5의 기본적인 문법과 요소들을 소개하는 튜토리얼입니다.", 1, 4, 150, now(), now()),
("CSS 레이아웃 기초", "CSS를 활용하여 다양한 레이아웃을 구성하는 방법을 배워봅시다.", 2, 4, 540, now(), now()),
("자바스크립트 함수 사용법", "자바스크립트에서 함수를 정의하고 활용하는 방법을 설명합니다.", 3, 4, 300, now(), now()),
("React 기본 사용법", "React를 사용하여 동적인 웹 애플리케이션을 만드는 방법을 소개합니다.", 4, 4, 210, now(), now()),
("파이썬 기초 문법", "파이썬 프로그래밍의 기초 문법을 배워보세요.", 5, 4, 380, now(), now());

insert into board (btitle, bcontent, mno, cno, bview, cdate, udate)
values
("최고의 스마트폰 사용 후기", "최근에 구매한 스마트폰에 대한 리뷰를 공유합니다. 성능과 디자인에 대해 설명합니다.", 1, 5, 820, now(), now()),
("이전에 사용했던 노트북 후기", "내가 사용해본 노트북에 대한 후기를 남겨봅니다. 속도와 디자인을 비교해봤습니다.", 2, 5, 915, now(), now()),
("온라인 쇼핑몰 이용 후기", "최근에 이용한 온라인 쇼핑몰에 대한 후기를 남깁니다. 배송과 서비스 품질을 평가합니다.", 3, 5, 670, now(), now()),
("가성비 좋은 이어폰 추천", "가성비 좋은 이어폰을 찾고 있다면, 이 제품을 추천드립니다. 가격 대비 성능이 뛰어나요.", 4, 5, 210, now(), now()),
("전문적인 카메라 리뷰", "프로페셔널 카메라를 사용해본 후기를 남깁니다. 사용감과 화질을 평가해보았습니다.", 5, 5, 590, now(), now());

-- reply sample
-- Insert 50 sample replies into reply table
insert into reply (rcontent, bno, mno, cdate, udate)
values
("좋은 정보 감사합니다!", 1, 1, now(), now()),
("할인 행사 너무 기대돼요!", 2, 2, now(), now()),
("AI 기술에 대해 더 자세히 알고 싶어요.", 3, 3, now(), now()),
("보안 강화 정책에 대한 더 많은 정보 부탁드립니다.", 4, 4, now(), now()),
("신제품에 대한 기대가 큽니다.", 5, 5, now(), now()),
("회원 가입 이벤트 너무 좋네요!", 6, 1, now(), now()),
("친구 초대 이벤트에 참여하고 싶어요.", 7, 2, now(), now()),
("리뷰 작성하면 포인트 받는 게 좋네요.", 8, 3, now(), now()),
("기프트 카드 이벤트에 참여하고 싶어요!", 9, 4, now(), now()),
("여름 세일 정말 필요한 제품 많아요.", 10, 5, now(), now()),
("회원 가입 방법 너무 쉽게 설명해주셔서 감사합니다.", 11, 1, now(), now()),
("비밀번호 변경 방법 정말 유용했어요.", 12, 2, now(), now()),
("배송 조회 방법을 따라 했더니 금방 찾았어요.", 13, 3, now(), now()),
("포인트 사용 방법을 잘 몰랐는데 잘 배웠습니다.", 14, 4, now(), now()),
("상품 반품 절차가 간단하네요.", 15, 5, now(), now()),
("HTML5 튜토리얼 덕분에 이해가 쉬웠어요.", 16, 1, now(), now()),
("CSS 레이아웃 기초 튜토리얼 재미있어요.", 17, 2, now(), now()),
("자바스크립트 함수 사용법 잘 배웠습니다.", 18, 3, now(), now()),
("React 기본 사용법 영상으로 보고 따라 해보았어요.", 19, 4, now(), now()),
("파이썬 기초 문법에 대해 공부 중입니다.", 20, 5, now(), now()),
("스마트폰 사용 후기 잘 봤어요. 참고하겠습니다.", 1, 1, now(), now()),
("노트북 후기 정말 도움이 되었습니다.", 2, 2, now(), now()),
("쇼핑몰 이용 후기 좋았어요. 자주 이용할게요.", 3, 3, now(), now()),
("이어폰 추천 감사합니다. 저도 가성비 좋은 제품을 찾고 있었어요.", 4, 4, now(), now()),
("카메라 리뷰도 많이 참고해야겠어요.", 5, 5, now(), now()),
("여름 시즌 제품들이 정말 좋네요!", 6, 1, now(), now()),
("할인 행사에 대한 소식 감사합니다.", 7, 2, now(), now()),
("AI 연구 결과에 대해 더 알고 싶어요.", 8, 3, now(), now()),
("보안 정책이 강화되어서 안심이에요.", 9, 4, now(), now()),
("2025 신제품도 관심이 갑니다.", 10, 5, now(), now()),
("회원 가입 이벤트 덕분에 포인트 받았어요.", 11, 1, now(), now()),
("친구 초대 이벤트에 참여했어요. 보너스 포인트는 언제 받을까요?", 12, 2, now(), now()),
("구매 후 리뷰 작성하니 포인트가 쌓였어요. 감사합니다.", 13, 3, now(), now()),
("기프트 카드 추첨 이벤트에 참여해요!", 14, 4, now(), now()),
("여름 세일로 구매한 제품이 만족스러워요.", 15, 5, now(), now()),
("회원 가입 절차가 간단해서 좋았어요.", 16, 1, now(), now()),
("비밀번호 변경하는 방법을 찾아서 바로 했어요.", 17, 2, now(), now()),
("배송 조회하는 방법을 몰랐는데 잘 배웠어요.", 18, 3, now(), now()),
("포인트를 쓰는 방법이 친절해서 좋아요.", 19, 4, now(), now()),
("상품 반품 절차가 복잡하지 않아서 좋았어요.", 20, 5, now(), now());

