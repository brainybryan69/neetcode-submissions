class Twitter:

    def __init__(self):
        self.posts = []
        self.followList = []
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.posts.append((userId, tweetId))
        

    def getNewsFeed(self, userId: int) -> List[int]:
        result = []
        following = [userId]
        for pair in self.followList:
            if pair[0] == userId:
                following.append(pair[1])

        for post in reversed(self.posts):
            if len(result) == 10:
                return result
            if post[0] in following:
                result.append(post[1])
        
        return result
        
        

    def follow(self, followerId: int, followeeId: int) -> None:
        if (followerId, followeeId) not in self.followList:
            self.followList.append((followerId, followeeId))
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if (followerId, followeeId) in self.followList:
            self.followList.remove((followerId, followeeId))
        
