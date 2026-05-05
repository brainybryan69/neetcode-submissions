# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        def reverseLinkedList(h: ListNode):
            prev, curr = None, h
            while curr:
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp
            return prev
        
        head = reverseLinkedList(head)

        tmp = head
        if n == 1:
            if head.next:
                head = head.next
                return reverseLinkedList(head)
            else:
                return None

        for i in range(1, n - 1):
            tmp = tmp.next
        
        if tmp.next and tmp.next.next:
            tmp.next = tmp.next.next
        elif tmp.next:
            tmp.next = None
        
        return reverseLinkedList(head)
             