Rem git init

Rem 원격저장소 연결
Rem git remote add origin https://github.com/qkrmekem/algorithm.git

Rem git add --all

Rem git commit -m "before reupload"

Rem Git 저장소에서 pull을 함과 동시에
Rem 로컬브랜치의 시작지점을 Git저장소의 최신 지점으로 설정
Rem git pull --rebase origin main

Rem push를 할 git저장소와 브랜치를 설정
Rem 이렇게 설정해두면 다음에 push할때 따로 저장소와 브랜치를 명시해주지 않아도 됨
Rem git push --set-upstream origin main

:loop

	cd D:\My Java\algorithm

	Rem git init

	git add --all

	git commit -m "auto commit"

	git pull

	git push
	
	TIMEOUT 300

goto loop
