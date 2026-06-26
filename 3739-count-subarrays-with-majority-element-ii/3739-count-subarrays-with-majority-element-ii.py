class Fenwick:
    def __init__(self, n):
        self.bit = [0] * (n + 2)

    def update(self, i, v):
        while i < len(self.bit):
            self.bit[i] += v
            i += i & -i

    def query(self, i):
        s = 0
        while i > 0:
            s += self.bit[i]
            i -= i & -i
        return s


class Solution:
    def countMajoritySubarrays(self, nums, target):
        n = len(nums)

        offset = n + 1
        size = 2 * n + 5

        bit = Fenwick(size)

        pref = 0
        ans = 0

        bit.update(offset, 1)      # prefix sum = 0

        for x in nums:
            if x == target:
                pref += 1
            else:
                pref -= 1

            ans += bit.query(pref + offset - 1)
            bit.update(pref + offset, 1)

        return ans