// 게시글 데이터 저장 배열
let posts = [
    { id: 1, title: '첫 번째 게시글', content: '게시글 내용입니다.', author: '홍길동', createdAt: '2023-04-01' },
    { id: 2, title: '두 번째 게시글', content: '두 번째 게시글 내용입니다.', author: '김철수', createdAt: '2023-04-02' },
    // 더 많은 게시글 데이터
];

// 게시글 목록 조회
function getPosts() {
    return posts;
}

// 게시글 작성
function createPost(post) {
    post.id = posts.length + 1;
    posts.push(post);
}

// 게시글 수정
function updatePost(id, updatedPost) {
    const index = posts.findIndex(post => post.id === id);
    if (index !== -1) {
        posts[index] = { ...posts[index], ...updatedPost };
    }
}

// 게시글 삭제
function deletePost(id) {
    posts = posts.filter(post => post.id !== id);
}