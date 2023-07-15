git init

::원격저장소 연결
git remote add origin https://github.com/qkrmekem/algorithm.git

git add --all

git commit -m "before reupload"

::Git 저장소에서 pull을 함과 동시에
::로컬브랜치의 시작지점을 Git저장소의 최신 지점으로 설정
git pull --rebase origin main

::push를 할 git저장소와 브랜치를 설정
::이렇게 설정해두면 다음에 push할때 따로 저장소와 브랜치를 명시해주지 않아도 됨
git push --set-upstream origin main

:loop

	cd D:\My Java\algorithm

	git init

	git add --all

	git commit -m "auto commit"

	git pull

	git push
	
	TIMEOUT 300

goto loop
