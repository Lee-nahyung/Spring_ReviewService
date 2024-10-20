from selenium.webdriver.chrome.options import Options
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains

import locale
import time
from time import sleep
from selenium import webdriver

# 크롬 드라이버 설정
driver = webdriver.Chrome()

# 네이버 지도 페이지 접속 (실제 URL로 교체 필요)
url = "https://map.naver.com/p/search/%EC%88%9C%EC%B2%9C%ED%96%A5%EB%8C%80%20%EC%8B%9D%EB%8B%B9?c=15.00,0,0,0,dh"
driver.get(url)

# 5초 대기 (iframe 로드 확인)
time.sleep(5)

# 첫 번째 iframe 전환
iframe = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CSS_SELECTOR, "iframe#searchIframe")))
driver.switch_to.frame(iframe)

page_num = 1
restaurant_num = 1  # 전체 식당 번호를 추적하기 위한 변수

while True:
    print(f"=== {page_num} 페이지 ===")

    # 페이지 내에서 스크롤을 내려 모든 식당을 로드
    last_height = driver.execute_script("return document.body.scrollHeight")
    while True:
        driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        time.sleep(2)
        new_height = driver.execute_script("return document.body.scrollHeight")
        if new_height == last_height:
            break
        last_height = new_height

    # 스크롤을 모두 내린 후, 식당 리스트 크롤링
    restaurants = driver.find_elements(By.XPATH, '/html/body/div[3]/div/div[2]/div[1]/ul/li')  # 모든 식당 리스트 선택
    for index, restaurant in enumerate(restaurants, start=1):
        try:
            # 식당명 가져오기
            restaurant_name = restaurant.find_element(By.XPATH, f'./div[1]/a/div/div/span[1]').text
            print(f"\n식당번호: {restaurant_num}, 식당명: {restaurant_name}")

            # 식당 클릭해서 상세 페이지로 이동
            restaurant.find_element(By.XPATH, f'./div[1]/a').click()
            time.sleep(5)  # 페이지 로드를 기다리기 위한 시간

            # iframe 전환 (상세 페이지로 이동 후)
            driver.switch_to.default_content()  # 기본 컨텍스트로 돌아오기
            detail_iframe = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CSS_SELECTOR, "iframe#entryIframe")))
            driver.switch_to.frame(detail_iframe)

            # 주소 가져오기
            try:
                address = driver.find_element(By.XPATH, '/html/body/div[3]/div/div/div/div[5]/div/div[2]/div[1]/div/div[1]/div/a/span[1]').text
            except:
                address = "null"  # 주소가 없으면 null 출력
            print(f"주소: {address}")

            # 전화번호 가져오기
            try:
                phone_number = driver.find_element(By.XPATH, '/html/body/div[3]/div/div/div/div[5]/div/div[2]/div[1]/div/div[3]/div/span[1]').text
            except:
                phone_number = "null"  # 전화번호가 없으면 null 출력
            print(f"전화번호: {phone_number}")

            # 다시 검색 리스트로 돌아가기
            driver.switch_to.default_content()
            iframe = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CSS_SELECTOR, "iframe#searchIframe")))
            driver.switch_to.frame(iframe)

            # 식당 번호 증가
            restaurant_num += 1

        except Exception as e:
            print(f"에러 발생: {e}")

    # 다음 페이지로 넘어가기
    try:
        next_page = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div[3]/div/div[2]/div[2]/a[5]')))
        next_page.click()
        time.sleep(5)  # 페이지 로드를 기다리기 위한 시간
        page_num += 1
    except Exception as e:
        print("더 이상 페이지가 없습니다. 크롤링을 종료합니다.")
        break

# 크롤링 완료 후 브라우저 닫기
driver.quit()
