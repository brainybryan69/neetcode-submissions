# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        total = 0
        magnitude = 1
        while l1 or l2:
            if l1: 
                total += (l1.val * magnitude)
                l1 = l1.next
            if l2: 
                total += (l2.val * magnitude)
                l2 = l2.next
            
            magnitude *= 10
        
        digit = total % 10
        total //= 10
        head = ListNode(digit)

        tmp = head

        while total > 0:
            digit = total % 10
            total //= 10
            tmp.next = ListNode(digit)
            tmp = tmp.next
        
        return head