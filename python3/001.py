#!/usr/bin/env python
# -*- coding: utf-8 -*-
from typing import List
import unittest

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) < 2 :return []
        for i,v1 in enumerate(nums[:-1]):
            for j,v2 in enumerate(nums[i+1:]):
                if v1+v2 == target:
                    return [i,j+i+1]
        return []

    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        if len(nums) < 2 :return []
        dict = {}
        for i,v in enumerate(nums):
            delta = target - v
            if delta in dict:
                return [dict[delta],i]
            dict[v] = i
        return []


class Test(unittest.TestCase):
    def test(self):
        a = Solution()
        self.assertEqual(a.twoSum2([3,2,4],6),[1,2])
        self.assertEqual(a.twoSum2([2,7,5,11],9),[0,1])

if __name__ == "__main__":
    unittest.main()
