function signUp() {
    if (document.signupForm.id.value == "") {
        alert("아이디를 입력해주세요")
        signupForm.id.focus();
        return false;
    }
    if (document.signupForm.password.value == "") {
        alert("비밀번호를 입력해주세요")
        signupForm.password.focus();
        return false;
    }
    if (document.signupForm.password2.value == "") {
        alert("비밀번호확인을 입력해주세요")
        signupForm.password2.focus();
        return false;
    }
    if (document.signupForm.email.value == "") {
        alert("이메일을 입력해주세요")
        signupForm.email.focus();
        return false;
    }

    document.signupForm.action = "signup"
    document.signupForm.method = "POST"
    document.signupForm.submit();
}