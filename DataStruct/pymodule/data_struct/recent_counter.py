class RecentCounter:

    def __init__(self):
        self.counter = 0
        self.list = []

    def ping(self, t: int) -> int:
        self.list.append(t)
        while len(self.list)>0 and t - 3000 > self.list[0]:
            self.list.remove(self.list[0])

        return len(self.list)


n = RecentCounter()
print(n.ping(1))
print(n.ping(100))
print(n.ping(3001))
print(n.ping(3002))